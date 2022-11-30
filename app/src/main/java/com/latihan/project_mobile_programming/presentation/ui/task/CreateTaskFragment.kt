package com.latihan.project_mobile_programming.presentation.ui.task

import android.annotation.SuppressLint
import android.app.*
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.latihan.project_mobile_programming.R
import com.latihan.project_mobile_programming.databinding.FragmentCreateTaskBinding
import com.latihan.project_mobile_programming.presentation.broadcast.*
import com.latihan.project_mobile_programming.presentation.viewmodel.TodoViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import java.util.*

class CreateTaskFragment :
    Fragment(),
    DatePickerDialog.OnDateSetListener,
    TimePickerDialog.OnTimeSetListener {

    private var _binding: FragmentCreateTaskBinding? = null
    private val binding get() = _binding!!

    private val viewModel by sharedViewModel<TodoViewModel>()
    private val args by navArgs<CreateTaskFragmentArgs>()

    private var day = 0
    private var month = 0
    private var year = 0
    private var hour = 0
    private var minute = 0
    private var pickedDay = 0
    private var pickedMonth = 0
    private var pickedYear = 0
    private var pickedHour = 0
    private var pickedMinute = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        createNotificationChannel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreateTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            toolbar.tvTitle.text = getString(R.string.title_create_task)
            toolbar.ibProfile.visibility = View.INVISIBLE

            toolbar.ibBack.setOnClickListener {
                findNavController().navigate(
                    CreateTaskFragmentDirections.actionCreateTaskFragmentToTaskFragment(
                        args.channel,
                        args.author
                    )
                )
            }

            tietDeadline.onFocusChangeListener =
                View.OnFocusChangeListener { view, isFocussed ->
                    if (isFocussed) {
                        val calendar: Calendar = Calendar.getInstance()
                        day = calendar.get(Calendar.DAY_OF_MONTH)
                        month = calendar.get(Calendar.MONTH)
                        year = calendar.get(Calendar.YEAR)
                        val datePickerDialog =
                            DatePickerDialog(
                                requireContext(),
                                this@CreateTaskFragment,
                                year,
                                month,
                                day
                            )
                        datePickerDialog.show()
                    }
                }

            fabCreate.setOnClickListener {
                val taskName = tietTaskName.text.toString().trim()
                val deadline = tietDeadline.text.toString().trim()

                if (taskName.isNotEmpty() && deadline.isNotEmpty()) {
                    scheduleNotification(taskName)

                    viewModel.insertTodo(taskName, args.channel, args.author, deadline, false)
                    findNavController().navigate(
                        CreateTaskFragmentDirections.actionCreateTaskFragmentToTaskFragment(
                            args.channel,
                            args.author
                        )
                    )
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Mohon isi data task dengan benar",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        pickedDay = day
        pickedYear = year
        pickedMonth = month
        val calendar: Calendar = Calendar.getInstance()
        hour = calendar.get(Calendar.HOUR)
        minute = calendar.get(Calendar.MINUTE)
        val timePickerDialog = TimePickerDialog(
            requireContext(), this@CreateTaskFragment, hour, minute,
            DateFormat.is24HourFormat(requireContext())
        )
        timePickerDialog.show()
    }

    @SuppressLint("SetTextI18n")
    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        pickedHour = hourOfDay
        pickedMinute = minute
        binding.tietDeadline.setText("$pickedDay-$pickedMonth-$pickedYear | $pickedHour:$pickedMinute")
    }

    private fun scheduleNotification(title: String) {
        val intent = Intent(requireContext(), NotificationBroadcast::class.java)
        val message = "Deadline: $pickedDay-$pickedMonth-$pickedYear | $pickedHour:$pickedMinute"
        intent.putExtra(titleExtra, title)
        intent.putExtra(messageExtra, message)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val pendingIntent = PendingIntent.getBroadcast(
                requireContext(),
                notificationID,
                intent,
                PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
            )

            val time = getDeadline()
            val alarmManager =
                requireContext().getSystemService(Context.ALARM_SERVICE) as AlarmManager

            alarmManager.setExactAndAllowWhileIdle(
                AlarmManager.RTC_WAKEUP,
                time,
                pendingIntent
            )
        }
    }

    private fun getDeadline(): Long {
        val calendar = Calendar.getInstance()
        calendar.set(pickedYear, pickedMonth, pickedDay, pickedHour, pickedMinute)
        calendar.add(Calendar.MINUTE, -30)
        return calendar.timeInMillis
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Task Notification Channel"
            val desc = "Channel for task notification"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channelID, name, importance)
            channel.description = desc
            val notificationManager =
                requireContext().getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}
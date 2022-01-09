package com.example.eventribe.data

import com.example.eventribe.R
import com.example.eventribe.model.Event

class EventDataSource {
    fun getEvents(): List<Event> {
        return listOf(
            Event(R.drawable.gdsc, "Event Title","Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts and visual mockups."),
            Event(R.drawable.gdsc,"Event Title","Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts and visual mockups."),
            Event(R.drawable.gdsc, "Event Title","Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts and visual mockups.")
        )
    }
}
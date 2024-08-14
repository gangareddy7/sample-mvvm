package com.empower.retirement.helpers

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun convertStringToDate(dateString: String?): String? {
    // Define the input format
    val inputFormat = SimpleDateFormat("MMddyyyy", Locale.getDefault())

    // Define the output format
    val outputFormat = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())

    // Parse the input date string
    val date: Date? = inputFormat.parse(dateString)

    // Format the date to the desired output format
    return date?.let { outputFormat.format(it) }
}
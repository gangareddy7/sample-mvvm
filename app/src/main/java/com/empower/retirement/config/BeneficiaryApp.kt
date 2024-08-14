package com.empower.retirement.config

import android.app.Application

class BeneficiaryApp : Application() {

    init {
        instance = this
    }
// Initialize application context
    companion object {
        private lateinit var instance: BeneficiaryApp

        fun getContext() = instance
    }

}
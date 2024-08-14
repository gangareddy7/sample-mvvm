package com.empower.retirement.ui.activities

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.empower.retirement.viewmodel.BeneficiaryViewModel

abstract class BaseActivity: AppCompatActivity() {
    // ViewModelProvider is used to share the data between activities
    val viewModel: BeneficiaryViewModel by lazy {
        ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory())[BeneficiaryViewModel::class.java]
    }
}
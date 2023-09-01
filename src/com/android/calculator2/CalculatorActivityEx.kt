package com.android.calculator2

import android.content.Context
import androidx.lifecycle.lifecycleScope
import calcmask.CalcMaskPasswordPresenter
import com.sovworks.projecteds.presentation.di.CalcMaskPresentationModule
import com.sovworks.projecteds.ui.common.StorageManagerTools
import com.sovworks.projecteds.ui.common.util.extensions.launchWhenResumedUnsafe
import com.sovworks.projecteds.ui.common.util.inject
import com.sovworks.projecteds.ui.common.util.viewModelScope

class CalculatorActivityEx(private val activity: Calculator) {

    private val calcMaskPasswordPresenter: CalcMaskPasswordPresenter by inject(
        activity.viewModelScope(CalcMaskPresentationModule.calcMaskScope)
    )

    fun loadFeatureModule() {
        CalculatorFeatureModule.load()
    }

    private fun startStorageManager(context: Context) {
        StorageManagerTools.startStorageManagerActivity(context)
    }

    fun checkInputPasswordText() {
        activity.lifecycleScope.launchWhenResumedUnsafe {
            calcMaskPasswordPresenter.isPasswordMatchFlow.collect { isMatched ->
                if (isMatched) {
                    startStorageManager(activity)
                }
            }
        }
    }

    fun setInputText(text: String) {
        calcMaskPasswordPresenter.setInputText(text)
    }
}
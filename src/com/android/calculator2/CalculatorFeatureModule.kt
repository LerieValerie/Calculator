package com.android.calculator2

import com.sovworks.projecteds.domain.common.annotation.Reflection
import com.sovworks.projecteds.domain.di.CalcMaskDomainModule
import com.sovworks.projecteds.presentation.di.CalcMaskPresentationModule
import com.sovworks.projecteds.ui.common.FeatureKoinModule

@Reflection
object CalculatorFeatureModule : FeatureKoinModule() {

    override val modules by lazy {
        listOf(CalcMaskPresentationModule(), CalcMaskDomainModule())
    }
}
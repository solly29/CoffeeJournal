package com.example.coffeejournal.domain.model

import com.example.coffeejournal.R
import com.example.coffeejournal.generated.callback.OnClickListener

data class AppBarData(
    var leftIcon: Int? = R.drawable.ic_baseline_arrow_back_ios_24,
    var title: String,
    var rightIcon: Int? = null,
    var rightIconClickListener: (() -> Unit)? = null
)

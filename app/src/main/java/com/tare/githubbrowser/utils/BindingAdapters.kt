package com.tare.githubbrowser.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import com.tare.githubbrowser.R
import de.hdodenhof.circleimageview.CircleImageView

@BindingAdapter("setImage")
fun bindImage(circleImageView: CircleImageView, url: String?){
    url?.let {
        Picasso.get().load(url).into(circleImageView)
    }
}

@BindingAdapter("setDate")
fun bindDate(textView: TextView, date: String?){
    date?.let {
        textView.text = DateHelper.formatDate(it)
    }
}

@BindingAdapter("setVerification")
fun bindTV(textView: TextView, verified: Boolean?){
    if(verified == true){
        textView.text = "Verified"
        textView.setBackgroundResource(R.drawable.textview_bg)
    }else if(verified == false){
        textView.text = "Not Verified"
        textView.setBackgroundResource(R.drawable.textview_bg_not)
    }
}
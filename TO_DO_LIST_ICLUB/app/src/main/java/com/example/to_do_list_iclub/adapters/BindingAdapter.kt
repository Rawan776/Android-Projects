package com.example.to_do_list_iclub.adapters

import android.widget.CheckBox
import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("setTask")
fun bindTask(task:TextView,item:String){
    task.text=item
}
@BindingAdapter("setchecked")
fun bindchecked(checkBox: CheckBox,isCheckedTextView:Boolean){
    checkBox.isChecked= isCheckedTextView

}

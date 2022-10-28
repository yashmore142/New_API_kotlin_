package com.example.new_api_kotlin.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.example.Data
import com.example.new_api_kotlin.R
import com.example.new_api_kotlin.view.DetailsUserActivity
import com.example.new_api_kotlin.view.MainActivity
import kotlin.coroutines.coroutineContext

class UserAdapter(private var mList: List<Data>,private var context: Context):RecyclerView.Adapter<UserAdapter.ViewHolder>() {


    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

        val txtId:TextView=itemView.findViewById(R.id.txtId)
        val txtEmail:TextView=itemView.findViewById(R.id.txtEmail)
        val txtFirstName:TextView=itemView.findViewById(R.id.txtFirstName)
        val txtLastName:TextView=itemView.findViewById(R.id.txtLastName)
        val imgUser:ImageView=itemView.findViewById(R.id.imgUser)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
     val view=LayoutInflater.from(parent.context).inflate(R.layout.item_user_view,parent,false)
    return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.txtId.text=mList[position].id.toString()
        holder.txtEmail.text=mList[position].email
        holder.txtFirstName.text=mList[position].firstName
        holder.txtLastName.text=mList[position].lastName

        Glide.with(context)
            .load(mList[position].avatar)
            .into(holder.imgUser)

        holder.itemView.setOnClickListener {
            val intent=Intent(context,DetailsUserActivity::class.java)
            intent.putExtra("id",mList[position].id.toString())
                .putExtra("email",mList[position].email)
                .putExtra("firstname",mList[position].firstName)
                .putExtra("lastname",mList[position].lastName)
                .putExtra("avtar",mList[position].avatar)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}
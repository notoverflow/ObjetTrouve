package com.example.objetceri

import com.example.objetceri.ItemRepository.Singleton.databseRef
import com.example.objetceri.ItemRepository.Singleton.itemList
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import javax.security.auth.callback.Callback

class ItemRepository {

    object Singleton {

        // connecct to the database

        val databseRef = FirebaseDatabase.getInstance().getReference("Item")

        // create a list of items


        val itemList = arrayListOf<ItemModel>()
    }


    fun updateData(callback: () -> Unit) {

        // get the data from the database

        databseRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                //remove the old data
                itemList.clear()

                //get the list of items
                for (ds in snapshot.children) {
                    val item = ds.getValue(ItemModel::class.java)

                    //  verify if the item is not null
                    if (item != null) {
                        itemList.add(item)
                    }
                }
                // call the callback
               callback()
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })
    }
}
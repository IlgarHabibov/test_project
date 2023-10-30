package com.example.atlandroidexamples.practices.practice11

import com.example.atlandroidexamples.db.entities.TextEntity

interface OnNoteClickListener {
    fun onItemDeleteClick(textEntity: TextEntity)
    fun onItemClick(textEntity: TextEntity)
}
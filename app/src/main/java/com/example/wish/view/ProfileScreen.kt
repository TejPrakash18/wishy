package com.example.wish.view

import android.content.Context

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat

import com.example.wish.R
import com.example.wish.databinding.FragmentProfileScreenBinding


class ProfileScreen : Fragment() {
    // TODO: Rename and change types of parameters
    private var _binding: FragmentProfileScreenBinding?= null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ):View {

        _binding = FragmentProfileScreenBinding.inflate(inflater, container, false)

       val sharedPreferences  = requireActivity().getSharedPreferences("mypref", Context.MODE_PRIVATE)

        val username = sharedPreferences.getString("username", "null")
        binding.tvUserName.text = username

        val firstLetter = username?.firstOrNull()?.uppercaseChar()?.toString()?: "N"

        val letterBitmap = createLetterBitmap(firstLetter)
        binding.userImage.setImageBitmap(letterBitmap)

//        Log.d("Tag", "finally here")

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun createLetterBitmap(letter:String):Bitmap  {
        val width = 80
        val height = 80

        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        val paint = Paint()
        paint.color = ContextCompat.getColor(requireContext(), R.color.black)
        paint.isAntiAlias = true
        canvas.drawCircle(width/2f, height/2f, width/2f, paint)
        paint.color = Color.WHITE
        paint.textSize = 40f
        paint.typeface = Typeface.DEFAULT_BOLD
        paint.textAlign = Paint.Align.CENTER

        // Draw the letter on the canvas
        canvas.drawText(letter, width / 2f, height / 2f - ((paint.descent() + paint.ascent()) / 2), paint)

        return bitmap

    }
}
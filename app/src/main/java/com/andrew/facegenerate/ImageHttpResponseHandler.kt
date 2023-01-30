package com.andrew.facegenerate

import android.graphics.BitmapFactory
import android.widget.ImageView
import com.loopj.android.http.Base64
import com.loopj.android.http.JsonHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONObject

class ImageHttpResponseHandler(private var imageView: ImageView) : JsonHttpResponseHandler()
{
    override fun onSuccess(statusCode: Int, headers: Array<out Header>, response: JSONObject) {
        super.onSuccess(statusCode, headers, response)
        val base64Data = response.getString("data")
        val image = Base64.decode(base64Data, Base64.DEFAULT)
        val bitmap = BitmapFactory.decodeByteArray(image, 0, image.size)
        imageView.setImageBitmap(bitmap)
    }
}
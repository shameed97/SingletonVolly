package com.example.singletonvolly;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class Msingleton {


    private static Msingleton msingleton;
    private RequestQueue requestQueue;
    private Context mtx;

    private Msingleton(Context context) {
        mtx = context;
        requestQueue = getRequestQueue();
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(mtx.getApplicationContext());
        }
        return requestQueue;
    }

    public static synchronized Msingleton getinstance(Context context) {
        if (msingleton == null) {
            msingleton = new Msingleton(context);
        }
        return msingleton;
    }

    public <T> void addRequest(Request<T> request) {
        requestQueue.add(request);

    }
}

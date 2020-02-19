package com.mayankkasera.triviaapp.data.que

import com.mayankkasera.triviaapp.pojo.Que

class QueRepo {
    fun getQue() : List<Que>{

        val que = ArrayList<Que>()

        que.add(Que("Who is the best cricketer in the world?",
            "Sachin Tendulkar",
            "Virat Kolli",
            "Adam Gilchirst",
            "Jacques Kallis",
            false))

        que.add(Que("What are the colors in the Indian national flag?",
            "White",
            "Yellow",
            "Orange",
            "Green",
            false))

        return que
    }
}
package network

import route.MyHttpRoute
import spark.Service

/**
 * @author Ahmed Yusuf
 */
class MyHttpServer {
    companion object{
        var instance = MyHttpServer()
    }

    init {
        val port = 1337
        val httpService = Service.ignite()
        httpService.port(port)
        httpService.threadPool(350)
        httpService.internalServerError("Error : 500 internal error")

        httpService.get("/myhttpserver", MyHttpRoute())
        println("Http server running on port : "+port)
    }
}
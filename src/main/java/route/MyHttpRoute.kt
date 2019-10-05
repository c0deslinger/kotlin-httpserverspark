package route

import core.Process
import spark.Request
import spark.Response
import spark.Route

/**
 * @author Ahmed Yusuf
 */
class MyHttpRoute : Route {
    override fun handle(request: Request, response: Response): Any {
        var respBody = "Params: <br>"
        var sumResult = 0
        request.queryParams().forEach {
            respBody += it+" "+request.queryParams(it)+"<br>"
            sumResult = Process.sum(sumResult, request.queryParams(it).toInt())
        }
        response.body(respBody+"Sum result: "+sumResult)
        return response.body()
    }
}
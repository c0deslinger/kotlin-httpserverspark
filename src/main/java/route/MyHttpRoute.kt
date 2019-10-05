package route

import spark.Request
import spark.Response
import spark.Route

/**
 * @author Ahmed Yusuf
 */
class MyHttpRoute : Route {
    override fun handle(request: Request, response: Response): Any {
        var respBody = "Params: "
        request.queryParams().forEach {
            respBody += it+" "+request.queryParams(it)+", "
        }
        response.body(respBody)
        return response.body()
    }
}
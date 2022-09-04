<?php 
    namespace App\Http\Controllers\Api;
    use App\Http\Controllers\Controller;

    class BaseController extends Controller {
        
        /**
             * success response method.
             *
            * @return \Illuminate\Http\Response
        */

        public function sendResponse($result, $message){
             
            $reponse=[
                'success' => true,
                'data'    => $result,
                'message' => $message,
            ];

            return response ()->json($reponse,200);


        }

         /**
            * return error response.
            *
            * @return \Illuminate\Http\Response
        */

        public function sendError($error, $errorMessages = [], $code = 404){
            
            $response = [
                'success' => false,
                'message' => $error,
            ];

            if(!empty($errorMessages)){
                $response['data'] = $errorMessages;
            }

            return response()->json($response, $code);
        }


    }
?>
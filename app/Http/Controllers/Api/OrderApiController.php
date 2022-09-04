<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use App\Models\Order;
use App\Models\OrderDetails;
use Validator;

class OrderApiController extends BaseController
{
     /**
     * Order api
     *
     * @return \Illuminate\Http\Response
     */
    public function order(Request $request){
        // $rules =[
        //     'order' => 'required',
        // ];

        // $input = $request->only('order_details');
        // $validator = Validator::make($input,$rules);

        // if($validator->fails()){
        //     return $this->sendError('Validation Error.', $validator->errors());       
        // }

    
        $user_id = $request->user_id;
        $restaurant_id = $request->restaurant_id;
        $address_details=$request->address_details;
        $total = $request->total;
        $order_details = $request->order_details;

        $order = new Order([
            'user_id' => $user_id,
            'restaurant_id' => $restaurant_id,
            'total' => $total,
            'address_details' => $address_details,
        ]);

        $order->save();

        $a = $order->id;
        foreach($order_details as $order_details){
            $foods_id = $order_details['food_id'];
            $quantity = $order_details['quantity'];

            $orderdet = new OrderDetails([
               'order_id' => $a,
               'foods_id' => $foods_id,
               'quantity' => $quantity,
            ]);
    
            $orderdet->save();
        }
            return $this->sendResponse($a, 'Order successfully.');
      
    }    
}
?>

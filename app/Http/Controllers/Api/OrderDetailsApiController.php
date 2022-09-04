<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\Restaurant;
use Illuminate\Support\Facades\Auth;
use App\Http\Controllers\RestaurantController; 
use Validator;

class OrderDetailsApiController extends BaseController
{
    
    // public function search($name){
    //     return Restaurant::where("name", $name)->get();
    //     // return $this->sendResponse($name, 'Restaurant data is loaded.');
    // }


    public function search(Request $request){
        $rules = [
            'search' => 'required',
        ];

        $input = $request->only('search');
        $validator = Validator::make($input,$rules);

        if($validator->fails()){
            return $this->sendError('Validation Error.', $validator->errors());       
        }

        $search = $request->search;
        $success= [];

        $restaurant = Restaurant::where('name','like','%'.$search.'%')->get();

    
        return $this->sendResponse($restaurant, 'Search Results');
    }

    

}

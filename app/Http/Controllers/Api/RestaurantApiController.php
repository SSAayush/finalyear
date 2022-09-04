<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Api\BaseController;
use App\Models\Restaurant;
use App\Http\Controllers\Controller;
use Illuminate\Http\Request;

class RestaurantApiController extends BaseController
{
    //
    public function index()
    {
        //
        $restaurant = Restaurant::all();
        return $this->sendResponse($restaurant, 'Restaurant data is loaded.');
    }

}

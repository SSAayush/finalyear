<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Http\Controllers\Api\BaseController;
use App\Models\Food;
use Illuminate\Http\Request;

class FoodApiController extends BaseController
{
    //
    public function index()
    {
        //
        $food = Food::all();
        return $this->sendResponse($food, 'Foods data.');
    }


}

<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Http\Controllers\Api\BaseController;
use App\Models\Category;
use App\Models\Food;
use App\Http\Resources\CategoryResource;
use Illuminate\Http\Request;

class CategoryApiController extends BaseController
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index(Request $request)
    {
        // {
        //     error : false,
        //     message : "Food and category",
        //     data: [
        //         {   
        //             name : Category1 
        //             foods : [{food1},{food2}]
                
        //          }
        //     ]
        // }
        
        //
        // $food = Food::where('category_id','=',$a)->first();
        // return $request;
        // return $request->restaurant_id;
        $restaurantId = $request->restaurant_id;
        $data = Category::where('restaurant_id','=',$request->restaurant_id)->get();
        // return $data;
        
        $result = array();
        foreach($data as $item){
            $category = new Category();
            $food = Food::where([
                ['categories_id','=',$item->id],
                ['restaurant_id','=',$restaurantId]
            ])->get();
            $category->id = $item->id;
            $category->is_category = true;
            $category->name = $item->name;
            $category->food = $food;
            $result[] = $category;
        }

        return $this->sendResponse($result,'Food menu found.');
        
    }
    

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        //
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        //
        // $category = Category::create($request->all());
        
        // return new CategoryResource($category);
    }

    /**
     * Display the specified resource.
     *
     * @param  \App\Models\Category  $category
     * @return \Illuminate\Http\Response
     */
    public function show(Category $category)
    {
        //
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\Models\Category  $category
     * @return \Illuminate\Http\Response
     */
    public function edit(Category $category)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Models\Category  $category
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, Category $category)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Models\Category  $category
     * @return \Illuminate\Http\Response
     */
    public function destroy(Category $category)
    {
        //
    }
}
?>


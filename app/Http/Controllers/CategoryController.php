<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Category;
use App\Models\Restaurant;
use App\Http\Resources\CategoryResource;

class CategoryController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        //
        $category = Category::all();
        // return CategoryResource::collection($category);
        return view('category.list',compact('category','category'));
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        //
        // return view('category.create');
        return view('category.create', [
    
            'restaurant' => Restaurant::all()
        ]);
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
        $request->validate([
            'txtName'=>'required',
            'txtStatus'=> 'required',
        ]);
 
        $category = new category([
            'name' => $request->get('txtName'),
            'restaurant_id' => $request->get('txtRestaurant'),
            'status'=> $request->get('txtStatus')
        ]);
 
        $category->save();
        return redirect('/category')->with('success', 'Category has been added');
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show(Category $category)
    {
        //
        return view('category.view',compact('category'));
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function edit(Category $category)
    {
        //
        $restaurant = Restaurant::all();
        $data = [
            'restaurant'  => $restaurant,
        ];
        return view('category.edit',$data);
       // return view('category.edit',compact('category'));
        // return view('category.edit', array('restaurants' => $restaurants));
        // $restaurant = Restaurant::all();
        // $data = [
        //     'restaurant'  => $restaurant,
            
        // ];
        // return view('category.edit',$data);
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, Category $category)
    {
        //
        $request->validate([
            'txtName'=>'required',
            'txtStatus'=> 'required'
        ]);
 
 
        $category = Category::find($category->id);
        $category->name = $request->get('txtName');
        $foods->restaurant_id = $request->get('txtRestaurant');
        $category->status = $request->get('txtStatus');
 
        $category->update();
 
        return redirect('/category')->with('success', 'Category updated successfully');
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy(Category $category)
    {
        //
        $category->delete();
        return redirect('/category')->with('success', 'Category deleted successfully');
    }
}

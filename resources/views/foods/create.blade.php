@extends('foods.layouts.app')
 
@section('content')
    <div class="row">
        <div class="col-lg-11">
            <h2>Add New Food</h2>
        </div>
        <div class="col-lg-1">
            <a class="btn btn-primary" href="{{ url('foods') }}"> Back</a>
        </div>
    </div>
 
    @if ($errors->any())
        <div class="alert alert-danger">
            <strong>Whoops!</strong> There were some problems with your input.<br><br>
            <ul>
                @foreach ($errors->all() as $error)
                    <li>{{ $error }}</li>
                @endforeach
            </ul>
        </div>
    @endif
    <form action="{{ route('foods.store') }}" method="POST">
        @csrf
        <div class="form-group">
            <label for="Name">Name:</label>
            <input type="text" class="form-control" id="txtName" placeholder="Enter Name of food " name="txtName">
        </div>

        <div class="form-group">
            <label for="Price">Price:</label>
            <input type="text" class="form-control" id="txtPrice" placeholder="Enter price of foods" name="txtPrice">
        </div>

        <div class="form-group">
        <label for="category">Select category:</label>
            <select name="txtCategory" class="form-control select2-multiple">
                <option value=""></option>
                @foreach($categories as $item)
                    <option value="{{$item->id}}">
                        {{$item->name}}
                    </option>
                @endforeach
            </select>
        </div>

        <div class="form-group">
        <label for="restaurant">Select restaurant:</label>
            <select name="txtRestaurant" class="form-control select2-multiple">
                <option value=""></option>
                @foreach($restaurant as $item)
                    <option value="{{$item->id}}">
                        {{$item->name}}
                    </option>
                @endforeach
            </select>
        </div>

       

        <!-- <div class="form-group">
            <label for="Category">Category:</label>
            <input type="text" class="form-control" id="txtCategory" placeholder="Enter price of foods" name="txtCategory">
        </div>

        
        <div class="form-group">
            <label for="Restaurant">Restaurant:</label>
            <input type="text" class="form-control" id="txtRestaurant" placeholder="Enter price of foods" name="txtRestaurant">
        </div> -->

        <div class="form-group">
            <label for="txturl">url:</label>
            <input type="text" class="form-control" id="txturl" placeholder="Enter url" name="txturl">
        </div>
        
        <div class="form-group">
            <label for="txtLastName">Status:</label>
            <input type="text" class="form-control" id="txtStatus" placeholder="Enter Status" name="txtStatus">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
@endsection
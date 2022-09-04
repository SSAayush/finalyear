@extends('foods.layouts.app')

 
@section('content')
    <div class="row">
        <div class="col-lg-11">
            <h2>Update Food</h2>
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
    <form method="post" action="{{ route('foods.update',$food->id) }}" >
        @method('PATCH')
        @csrf
        <div class="form-group">
            <label for="txtName"> Name:</label>
            <input type="text" class="form-control" id="txtName" placeholder="Enter Name" name="txtName" value="{{ $food->name }}">
        </div>

        <div class="form-group">
            <label for="txtPrice">Price:</label>
            <input type="text" class="form-control" id="txtPrice" placeholder="Enter Price " name="txtPrice" value="{{ $food->price }}">
        </div>

        <div class="form-group">
            <label for="txtCategory">Category:</label>
            <input type="text" class="form-control" id="txtCategory" placeholder="Enter Price " name="txtCategory" value="{{ $food->category }}">
        </div>

        <!-- <div class="form-group">
            <label for="txtRestaurant">Restaurant:</label>
            <input type="text" class="form-control" id="txtRestaurant" placeholder="Enter Price " name="txtRestaurant" value="{{ $food->restaurant }}">
        </div> -->

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


        <div class="form-group">
            <label for="txtLastName">Status:</label>
            <input type="text" class="form-control" id="txtStatus" placeholder="Enter Status" name="txtStatus" value="{{ $food->status }}">
        </div>
   
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
@endsection
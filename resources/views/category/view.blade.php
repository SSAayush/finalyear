@extends('category.layouts.app')
 
@section('content')
    <div class="row">
        <div class="col-lg-11">
                <h2>Show Category</h2>
        </div>
        <div class="col-lg-1">
            <a class="btn btn-primary" href="{{ url('category') }}"> Back</a>
        </div>
    </div>
    <table class="table table-bordered">
        <tr>
            <th>Name:</th>
            <td>{{ $category->name }}</td>
        </tr>

        <tr>
            <th>Restaurant:</th>
            <td>{{ $category->restaurant_id }}</td>
        </tr>

        <tr>
            <th>Status:</th>
            <td>{{ $category->status }}</td>
        </tr>
 
    </table>
@endsection
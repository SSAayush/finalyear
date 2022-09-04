@extends('foods.layouts.app')
<!-- @extends ('master') -->
 
@section('content')
    <div class="row">
        <div class="col-lg-11">
                <h2>Foods</h2>
        </div>
        <div class="col-lg-1">
        <a class="btn btn-success" href="{{ route('foods.create') }}">Add</a>
        </div>
    </div>
 
    @if ($message = Session::get('success'))
        <div class="alert alert-success">
            <p>{{ $message }}</p>
        </div>
    @endif
 
    <table class="table table-bordered">
        <tr>
            <th>No</th>
            <th>Name</th>
            <th>Price</th>
            <th>Category</th>
            <th>Restaurant</th>
            <th>url</th>
            <th>Status</th>
            <th width="280px">Action</th>
        </tr>
        @php
            $i = 0;
        @endphp
        @foreach ($foods as $item)
            <tr>
                <td>{{ ++$i }}</td>
                <td>{{ $item->name }}</td>
                <td>{{ $item->price }}</td>
                <td>{{ $item->categories_id }}</td>
                <td>{{ $item->restaurant_id }}</td>
                <td>{{ $item->url }}</td>
                <td>{{ $item->status }}</td>
                <td>
                    <form action="{{ route('foods.destroy',$item->id) }}" method="POST">
                        <a class="btn btn-info" href="{{ route('foods.show',$item->id) }}">Show</a>
                        <a class="btn btn-primary" href="{{ route('foods.edit',$item->id) }}">Edit</a>
                        @csrf
                        @method('DELETE')
                        <button type="submit" class="btn btn-danger">Delete</button>
                    </form>
                </td>
            </tr>
        @endforeach
    </table>
@endsection
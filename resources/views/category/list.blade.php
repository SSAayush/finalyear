@extends('category.layouts.app')
<!-- @extends ('master') -->
 
@section('content')
    <div class="row">
        <div class="col-lg-11">
                <h2>Category</h2>
        </div>
        <div class="col-lg-1">
        <a class="btn btn-success" href="{{ route('category.create') }}">Add</a>
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
            <th>Restaurant</th>
            <th>Status</th>
            <th width="280px">Action</th>
        </tr>
        @php
            $i = 0;
        @endphp
        @foreach ($category as $category)
            <tr>
                <td>{{ ++$i }}</td>
                <td>{{ $category->name }}</td>
                <td>{{ $category->restaurant_id }}</td>
                <td>{{ $category->status }}</td>
                <td>
                    <form action="{{ route('category.destroy',$category->id) }}" method="POST">
                        <a class="btn btn-info" href="{{ route('category.show',$category->id) }}">Show</a>
                        <a class="btn btn-primary" href="{{ route('category.edit',$category->id) }}">Edit</a>
                        @csrf
                        @method('DELETE')
                        <button type="submit" class="btn btn-danger">Delete</button>
                    </form>
                </td>
            </tr>
        @endforeach
    </table>
@endsection
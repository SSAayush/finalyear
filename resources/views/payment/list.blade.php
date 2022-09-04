@extends('payment.layout.app')
@section('content')
    <div class="row">
        <div class="col-lg-11">
                <h2>Payment</h2>
        </div>
        <div class="col-lg-1">
        <a class="btn btn-success" href="{{ route('payment.create') }}">Add</a>
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
            <th>PaymentStatus</th>
            <th>Status</th>
            <th width="280px">Action</th>
        </tr>
        @php
            $i = 0;
        @endphp
        @foreach ($payment as $payment)
            <tr>
                <td>{{ ++$i }}</td>
                <td>{{ $payment->User }}</td>
                <td>{{ $payment->restaurant_id }}</td>
                <td>{{ $payment->status }}</td>
                <td>
                   
                </td>
            </tr>
        @endforeach
    </table>
@endsection
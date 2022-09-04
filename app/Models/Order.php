<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Order extends Model
{
    public $table = 'order' ;
    use HasFactory;
    protected $fillable = [
        'user_id',
        'restaurant_id',
        'address_details',
        'total',      
    ];
}

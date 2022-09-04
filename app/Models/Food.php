<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

use Spatie\MediaLibrary\HasMedia;
use Spatie\MediaLibrary\InteractsWithMedia;
use Spatie\MediaLibrary\MediaCollections\Models\Media;

class Food extends Model implements HasMedia
{
    use HasFactory;
    protected $fillable = [
        'name',
        'price',
        'categories_id',
        'restaurant_id',
        'url',
        'status',      
    ];

    use InteractsWithMedia;

    protected $primaryKey = 'id';

    public function categories()
    {
        return $this->hasOne(Category::class);
    }


    // public function restaurant()
    // {
    //     return $this->hasOne(restaurant::class);
    // }


}


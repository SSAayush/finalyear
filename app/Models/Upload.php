<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Spatie\MediaLibrary\HasMedia;
use Spatie\MediaLibrary\InteractsWithMedia;


class Upload extends Model implements HasMedia
{
   // use HasFactory;
   use InteractsWithMedia;


//     public function registerMediaConversions(Media $media = null): void
// {
//     $this
//         ->addMediaConversion('preview')
//         ->fit(Manipulations::FIT_CROP, 300, 300)
//         ->nonQueued();


}

// Route::get('add-media-from-request',[UploadController::class, 'create']);
// Route::get('add-media-from-request',[UploadController::class, 'store']);

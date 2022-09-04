<h1> 
    Upload photo
</h1>

<form action="{{ route('upload.store') }}" method="POST">
        @csrf
        <div class="form-group">
            <label for="Name">Image Upload:</label>
            <input type="file" class="form-control" name="image">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
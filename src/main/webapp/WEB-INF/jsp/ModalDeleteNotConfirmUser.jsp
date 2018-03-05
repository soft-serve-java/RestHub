<div class="modal fade" id="exampleModalDeleteNotConfirmedUsers" tabindex="-1" role="dialog" aria-labelledby="exampleModalDeleteNotConfirmedUsers"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="ModalDeleteNotConfirmedUsers">Are you sure?</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">

            </div>

            <div class="modal-footer">
                <a href="/admin/user/delete/" class="btn btn-success">Yes</a>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">No</button>
            </div>
        </div>
    </div>
</div>
<script>
    $('#exampleModalDeleteNotConfirmedUsers').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget); // Button that triggered the modal
        var recipient = button.data('whatever');
        var href = button.data('href');
        $("#delete").attr("action", href);
        var modal = $(this);
        modal.find('.modal-body').text('Do you want to delete all not confirmed users?');
    })
</script>
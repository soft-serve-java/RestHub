<div class="modal fade" id="exampleModalWaiter" tabindex="-1" role="dialog" aria-labelledby="exampleModalWaiterLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalWaiterLabel">Are you sure?</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">

            </div>

            <div class="modal-footer">
               <button type="button" class="btn btn-success" onclick="doPOSTonCallWaiter()" data-dismiss="modal">Yes</button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">No</button>
            </div>
        </div>
    </div>
</div>
<script>

    $('#exampleModalWaiter').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget) ; // Button that triggered the modal
        var recipient = button.data('whatever');
        var href = button.data('href');
        $("#delete").attr("action", href);
        var modal = $(this);
        modal.find('.modal-body').text('Do you want to call a waiter ?');
    })
</script>
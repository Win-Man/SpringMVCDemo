/**
 * Created by sg on 2016/7/21.
 */
function createConfirmAndCancleDialog(modalDivId, title, content, confirmFunc) {
    var innerHtml = "";
    innerHtml += '<div class="modal fade" ';
    innerHtml += 'id="';
    innerHtml += modalDivId;
    innerHtml += '-modal"';
    innerHtml += ' tabindex="-1" role="dialog" aria-labelledby="';
    innerHtml += modalDivId;
    innerHtml += '-title" aria-hidden="true">';
    innerHtml += '<div class="modal-dialog' + '">';
    innerHtml+='<div class="modal-content'+'">';
    //title
    innerHtml+='<div class="modal-header'+'">';
    innerHtml+='<h4 class="modal-title'+'" '+'id="';
    innerHtml+=modalDivId+'-title">';
    innerHtml+=title;
    innerHtml+='<h4'+'>';
    innerHtml+='</div'+'>';
    //content
    innerHtml+='<div class="modal-body'+'">';
    innerHtml+=content;
    innerHtml+='</div'+'>';
    //footer
    innerHtml+='<div class="modal-footer'+'">';
    //confirm button
    innerHtml+='<button type="button'+'" class='+'"btn btn-primary'+'" onclick="'+confirmFunc+'">';
    innerHtml+='确认';
    innerHtml+='</button'+'>';
    //cancel button
    innerHtml+='<button type="button'+'" class='+'"btn btn-default'+'" data-dismiss='+'"modal'+'">';
    innerHtml+='取消';
    innerHtml+='</button'+'>';

    innerHtml+='</div'+'>';
    innerHtml+='</div'+'>';
    innerHtml+='</div'+'>';
    innerHtml+='</div'+'>';

    $('#' + modalDivId).html(innerHtml.toString());
    $('#' + modalDivId + '-modal').modal('show');

    $('#' + modalDivId + '-modal').on('hidden.bs.modal',function () {
        $('#' + modalDivId + '-modal').remove();
    });
}

function createConfirmDialog(modalDivId,title,content){
    var innerHtml = "";
    innerHtml += '<div class="modal fade" ';
    innerHtml += 'id="';
    innerHtml += modalDivId;
    innerHtml += '-modal"';
    innerHtml += ' tabindex="-1" role="dialog" aria-labelledby="';
    innerHtml += modalDivId;
    innerHtml += '-title" aria-hidden="true">';
    innerHtml += '<div class="modal-dialog' + '">';
    innerHtml+='<div class="modal-content'+'">';
    //title
    innerHtml+='<div class="modal-header'+'">';
    innerHtml+='<h4 class="modal-title'+'" '+'id="';
    innerHtml+=modalDivId+'-title">';
    innerHtml+=title;
    innerHtml+='<h4'+'>';
    innerHtml+='</div'+'>';
    //content
    innerHtml+='<div class="modal-body'+'">';
    innerHtml+=content;
    innerHtml+='</div'+'>';
    //footer
    innerHtml+='<div class="modal-footer'+'">';
    //cancel button
    innerHtml+='<button type="button'+'" class='+'"btn btn-default'+'" data-dismiss='+'"modal'+'">';
    innerHtml+='确认';
    innerHtml+='</button'+'>';

    innerHtml+='</div'+'>';
    innerHtml+='</div'+'>';
    innerHtml+='</div'+'>';
    innerHtml+='</div'+'>';

    $('#' + modalDivId).html(innerHtml.toString());
    $('#' + modalDivId + '-modal').modal('show');

    $('#' + modalDivId + '-modal').on('hidden.bs.modal',function () {
        $('#' + modalDivId + '-modal').remove();
    });
}

function createConfirmAndCancleDialogWitnLoad(modalDivId, title, url,data, confirmFunc) {
    var innerHtml = "";
    innerHtml += '<div class="modal fade" ';
    innerHtml += 'id="';
    innerHtml += modalDivId;
    innerHtml += '-modal"';
    innerHtml += ' tabindex="-1" role="dialog" aria-labelledby="';
    innerHtml += modalDivId;
    innerHtml += '-title" aria-hidden="true">';
    innerHtml += '<div class="modal-dialog' + '">';
    innerHtml+='<div class="modal-content'+'">';
    //title
    innerHtml+='<div class="modal-header'+'">';
    innerHtml+='<h4 class="modal-title'+'" '+'id="';
    innerHtml+=modalDivId+'-title">';
    innerHtml+=title;
    innerHtml+='<h4'+'>';
    innerHtml+='</div'+'>';
    //content
    innerHtml+='<div class="modal-body'+'">';

    innerHtml+='</div'+'>';
    //footer
    innerHtml+='<div class="modal-footer'+'">';
    //confirm button
    innerHtml+='<button type="button'+'" class='+'"btn btn-primary'+'" onclick="'+confirmFunc+'">';
    innerHtml+='确认';
    innerHtml+='</button'+'>';
    //cancel button
    innerHtml+='<button type="button'+'" class='+'"btn btn-default'+'" data-dismiss='+'"modal'+'">';
    innerHtml+='取消';
    innerHtml+='</button'+'>';

    innerHtml+='</div'+'>';
    innerHtml+='</div'+'>';
    innerHtml+='</div'+'>';
    innerHtml+='</div'+'>';

    $('#' + modalDivId).html(innerHtml.toString());
    $('#' + modalDivId + '-modal').modal('show');

    $('.modal-body').load(url,data);

    $('#' + modalDivId + '-modal').on('hidden.bs.modal',function () {
        $('#' + modalDivId + '-modal').remove();
    });
}
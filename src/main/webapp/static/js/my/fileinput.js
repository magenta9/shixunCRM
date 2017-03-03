$(function () {
  $("#user_file").fileinput({
      language : 'zh',
      showUpload : false,
      showRemove : false,
      allowedPreviewTypes: ['image'],
      allowedFileTypes: ['image'],
      allowedFileExtensions:  ['jpg', 'png'],
      maxFileSize : 2000,
  });
});

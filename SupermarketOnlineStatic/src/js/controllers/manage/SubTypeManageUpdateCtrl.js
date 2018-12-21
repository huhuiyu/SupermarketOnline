(function () {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('SubTypeManageUpdateCtrl', ['$scope', '$log', 'DialogService', 'DataService', SubTypeManageUpdateCtrl]);

  function SubTypeManageUpdateCtrl($scope, $log, DialogService, DataService) {
    $log.debug('SubTypeManageUpdateCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function () {
      $log.debug('SubTypeManageUpdateCtrl destroy...');
    });

    var cdata = DialogService.getCustomData();
    $scope.types = cdata.types;
    $scope.formdata = cdata.type;

    $scope.save = function () {
      DialogService.showWait('数据保存中，请稍候...');
      DataService.send('/subtype/update', {
        subType: $scope.formdata
      }, function (data) {
        DialogService.hideWait();
        DialogService.showAlert(data.message, function () {
          if (data.success) {
            DialogService.hideCustom();
          }
        });
      });
    };

    $scope.close = function () {
      DialogService.hideCustom();
    };
  }
})();
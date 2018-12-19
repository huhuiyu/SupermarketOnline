(function () {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('TypeManageUpdateCtrl', ['$scope', '$log', 'DialogService', 'DataService', TypeManageUpdateCtrl]);

  function TypeManageUpdateCtrl($scope, $log, DialogService, DataService) {
    $log.debug('TypeManageUpdateCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function () {
      $log.debug('TypeManageUpdateCtrl destroy...');
    });

    $scope.formdata = DialogService.getCustomData();

    $scope.query = function () {
      DialogService.showWait('数据查询中，请稍候...');
      DataService.send('/type/queryByKey', {
        tbType: $scope.formdata
      }, function (data) {
        DialogService.hideWait();
        //成功且数据存在才修改
        if (data.success && data.datas && data.datas.type) {
          $scope.formdata = data.datas.type;
          return;
        }
        DialogService.showAlert('查询失败', function () {
          DialogService.hideCustom();
        });
      });
    };

    $scope.query();

    $scope.close = function () {
      DialogService.hideCustom();
    };

    $scope.save = function () {
      DialogService.showWait('数据保存中，请稍候...');
      DataService.send('/type/update', {
        tbType: $scope.formdata
      }, function (data) {
        DialogService.hideWait();
        DialogService.showAlert(data.message, function () {
          if (data.success) {
            DialogService.hideCustom();
          }
        });
      });
    };

  }
})();
(function () {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('SubTypeManageCtrl', ['$scope', '$log', 'DialogService', 'DataService', SubTypeManageCtrl]);

  function SubTypeManageCtrl($scope, $log, DialogService, DataService) {
    $log.debug('SubTypeManageCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function () {
      $log.debug('SubTypeManageCtrl destroy...');
    });

    $scope.page = {
      pageNumber: 1,
      pageSize: 10
    };

    $scope.query = function () {
      DialogService.showWait('数据查询中，请稍候...');
      DataService.send('/subtype/queryAll', {
        page: $scope.page
      }, function (data) {
        DialogService.hideWait();
        if (!data.success) {
          DialogService.showAlert(data.message);
          return;
        }
        //判断是否存在分类
        if (!data.datas.types || data.datas.types.length == 0) {
          DialogService.showAlert('请先添加分类');
          return;
        }
        $scope.types = data.datas.types;
        $scope.page = data.datas.page;
        $scope.list = data.datas.list;
      });

    };

    $scope.query();

    $scope.toAdd = function () {
      DialogService.showCustom('templates/manage/subtypemanage-add.html', {
        types: $scope.types
      }, function () {
        $scope.query();
      });
    };

  }
})();
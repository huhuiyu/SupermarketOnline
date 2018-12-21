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
      pageSize: 3
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

    //解决tid显示成名称的问题
    $scope.showTypeName = function (tid) {
      for (var i = 0; i < $scope.types.length; i++) {
        var type = $scope.types[i];
        if (tid == type.tid) {
          return type.typeName;
        }
      }
      return '';
    };

    //启用和禁用
    $scope.changeEnable = function (subtype, enable) {
      var url = enable == 'y' ? '/subtype/enable' : '/subtype/disable';
      DialogService.showWait('处理中，请稍候');
      DataService.send(url, {
        subType: subtype
      }, function (data) {
        DialogService.hideWait();
        DialogService.showAlert(data.message, function () {
          if (data.success) {
            $scope.query();
          }
        });
      });

    };

    //分页跳转
    $scope.toPage = function (pn) {
      //不能超出范围
      if (pn <= 0 || pn > $scope.page.pageCount || pn == $scope.page.pageNumber) {
        return;
      }
      //分页查询
      $scope.page.pageNumber = pn;
      $scope.query();
    };

    //转到修改
    $scope.toUpdate = function (subtype) {
      DialogService.showCustom('templates/manage/subtypemanage-update.html', {
        types: $scope.types,
        type: subtype
      }, function () {
        $scope.query();
      });
    };

  }
})();
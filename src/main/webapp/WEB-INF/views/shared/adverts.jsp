
          <!-- TO DO List -->

          
          
          <div class="box box-primary">
            <div class="box-header">
              <i class="ion ion-clipboard"></i>

              <h3 class="box-title">Disabled  Adverts</h3>
              <div class="box-tools pull-right">
                <ul class="pagination pagination-sm inline">
                  <li><a href="#">&laquo;</a></li>
                  <li><a href="#">1</a></li>
                  <li><a href="#">2</a></li>
                  <li><a href="#">3</a></li>
                  <li><a href="#">&raquo;</a></li>
                </ul>
              </div>
              </div>
        <div class="box-body">      
     <table class="table">
  <thead class="thead-light">
    <tr>
      <th scope="col">Category</th>
      <th scope="col">Item</th>
      <th scope="col">Item cost</th>
      <th scope="col">Advert cost</th>
      <th scope="col">Transaction ID</th>
      <th scope="col">Start Date</th>
      <th scope="col">No Days</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${disAdds}" var="disadd">
    <tr>
    
      <th scope="row">${disadd.cid}</th>
      <td data-toggle="tooltip"
						data-placement="top" title="website ${disadd.website}">${disadd.title} </td>
      <td>${disadd.itemAmount}</td>
      <td data-toggle="tooltip"
						data-placement="top" title="no of clicks ${disadd.noClicks}">${disadd.advertAmount}</td>
      <td>${disadd.transactionId}</td>
      <td><small class="label label-danger"><i class="fa fa-clock-o"></i>${disadd.dateFrom}</small></td>
      <td>${disadd.noDays}</td>
      <td><a href="/admin/enableadd?aid=${disadd.id}"> <i class="fa fa-edit">Enable<small class="label label-danger">${disadd.isNew}</small></i></a></td>
    </tr>
    </c:forEach>

  </tbody>
</table>
</div>


            <!-- /.box-body -->
            <div class="box-footer clearfix no-border">
              <button type="button" class="btn btn-default pull-right"><i class="fa fa-plus"></i> Add item</button>
            </div>
          </div>
          <div class="box box-primary">
            <div class="box-header">
              <i class="ion ion-clipboard"></i>

              <h3 class="box-title">Enabled Adverts</h3>

              <div class="box-tools pull-right">
                <ul class="pagination pagination-sm inline">
                  <li><a href="#">&laquo;</a></li>
                  <li><a href="#">1</a></li>
                  <li><a href="#">2</a></li>
                  <li><a href="#">3</a></li>
                  <li><a href="#">&raquo;</a></li>
                </ul>
              </div>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <!-- See dist/js/pages/dashboard.js to activate the todoList plugin -->
              <table class="table">
  <thead class="thead-light">
    <tr>
      <th scope="col">Category</th>
      <th scope="col">Item</th>
      <th scope="col">Item cost</th>
      <th scope="col">Advert cost</th>
      <th scope="col">Transaction ID</th>
      <th scope="col">Start Date</th>
      <th scope="col">No Days</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${enabAdds}" var="enabadd">
    <tr>
    
      <th scope="row">${enabadd.cid}</th>
      <td data-toggle="tooltip"
						data-placement="top" title="website ${enabadd.website}">${enabadd.title}</td>
      <td>${enabadd.itemAmount}</td>
      <td data-toggle="tooltip"
						data-placement="top" title="no of clicks ${enabadd.noClicks}">${enabadd.advertAmount}</td>
      <td>${enabadd.transactionId}</td>
      <td><small class="label label-danger"><i class="fa fa-clock-o"></i>${enabadd.dateFrom}</small></td>
      <td>${enabadd.noDays}</td>
      <td><a href="/admin/disableadd?aid=${enabadd.id}"><i class="fa fa-trash-o">Disable</i></a></td>
    </tr>
    </c:forEach>

  </tbody>
</table>            
            </div>
            <!-- /.box-body -->
            <div class="box-footer clearfix no-border">
              <button type="button" class="btn btn-default pull-right"><i class="fa fa-plus"></i> Add item</button>
            </div>
          </div>
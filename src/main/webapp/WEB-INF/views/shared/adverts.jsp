
          <!-- TO DO List -->
          <div class="box box-primary">
            <div class="box-header">
              <i class="ion ion-clipboard"></i>

              <h3 class="box-title">Enable paid up Adverts</h3>

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
              <ul class="todo-list">
              <c:forEach items="${disAdds}" var="disadd">
                <li>
                  <!-- drag handle -->
                  <span class="handle">
                        <i class="fa fa-ellipsis-v"></i>
                        <i class="fa fa-ellipsis-v"></i>
                      </span>
                  <!-- checkbox -->
                  <input type="checkbox" value="">
                  <!-- todo text -->
                  <span class="text">${disadd.title}</span>
                  <span class="text">${disadd.advertAmount}</span>
                  <span class="text">${disadd.advertAmount}</span>
                  <span class="text">${disadd.transactionId}</span>
                  <!-- Emphasis label -->
                  <small class="label label-danger"><i class="fa fa-clock-o"></i>${disadd.dateFrom} </small>
                  <!-- General tools such as edit or delete-->
                  <div class="tools">
                   <a href="/admin/enableadd?aid=${disadd.id}"> <i class="fa fa-edit">Enable</i></a>
                    <a href="/admin/disableadd?aid=${disadd.id}"><i class="fa fa-trash-o">Disable</i></a>
                  </div>
                </li>
                </c:forEach>
                
                </li>
    
              </ul>
            </div>
            <!-- /.box-body -->
            <div class="box-footer clearfix no-border">
              <button type="button" class="btn btn-default pull-right"><i class="fa fa-plus"></i> Add item</button>
            </div>
          </div>
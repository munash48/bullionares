<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div class="row">

          <div class="box">
            <div class="box-header">
              <h3 class="box-title">Top 10 Performers in Category ${category.catName}</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body no-padding">
              <table class="table table-striped">
              
                <tr>
                  <th style="width: 10px">#</th>
                  <th style="width: 200px">User</th>
                  <th>Progress</th>
                  <th style="width: 40px">%</th>
                </tr>
                <c:forEach items="${top10CatCounters}" var="catcounter">
                <tr>
                
                  <td>${catcounter.snumber}</td>
                  <td>${catcounter.fullName}</td>
                  <td>
                    <div class="progress progress-xs">
                      <div class="progress-bar ${catcounter.color}" style="width: ${catcounter.percentage}%"></div>
                    </div>
                  </td>
                  <td><span class="badge ${catcounter.color}">${catcounter.percentage}%</span></td>
                </tr>
                </c:forEach>

              </table>
            </div>
            <!-- /.box-body -->
          </div>
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">Top 10 Performers over all</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body no-padding">
            
              <table class="table table-striped">
                <tr>
                  <th style="width: 10px">#</th>
                  <th style="width: 150px">User</th>
                  <th style="width: 100px">Category</th>
                  <th>Progress</th>
                  <th style="width: 40px">%</th>
                </tr>
                <c:forEach items="${top10Counters}" var="catcounter">
           <tr>
                
                  <td>${catcounter.snumber}</td>
                  <td>${catcounter.fullName}</td>
                  <td>${catcounter.category}</td>
                  <td>
                    <div class="progress progress-xs">
                      <div class="progress-bar ${catcounter.color}" style="width: ${catcounter.percentage}%"></div>
                    </div>
                  </td>
                  <td><span class="badge ${catcounter.color}">${catcounter.percentage}%</span></td>
                </tr>
                
                </c:forEach>

              </table>
            </div>
            <!-- /.box-body -->
          </div>
</div>
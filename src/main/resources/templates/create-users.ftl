<#import "/spring.ftl" as spring /> <#import "macro.ftl" as macro/>

<@macro.showHeader />

<div class="row" ng-controller="createUsersCtrl">
	<div ng-if="!displayAddForm" class="col-md-1">
		<button ng-click="addForm();"
			class="form-control btn-primary pull-left">Add</button>
	</div></br></br></br>

	<div ng-if="displayAddForm">

		<div class="row">
			</br>
			<div class="text-center">
				<b>Register User<b>
			</div>
		</div>

		<div class="col-md-10">
			<div class="form-horizontal">
				<div class="form-group">
					<label class="control-label col-sm-2">Name:</label>
					<div class="col-sm-10">
						<input type="text" ng-model="thisUser.name" class="form-control"
							value="{{thisUser.name}}" required>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">User Name:</label>
					<div class="col-sm-10">
						<input type="text" ng-model="thisUser.userName" name="userName"
							class="form-control" value="{{thisUser.userName}}" required>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2">Email Id:</label>
					<div class="col-sm-10">
						<input type="text" ng-model="thisUser.email" name="email"
							value="{{thisUser.email}}" class="form-control" required />
					</div>
				</div>

			</div>

			<div class="form-group">
				<div class="col-md-2">
					<button ng-click="saveUsers(thisUser)"
						class="form-control btn-primary">Save</button>
				</div>
				<div class="col-md-2">
					<button ng-click="closeForm();" class="form-control btn-primary">Close</button>
				</div>
			</div>
			<div class="form-group"></div>
		</div>
	</div>
	<div ng-if="!displayAddForm">
		<div class="clearfix"></div>
			<div class="col-md-4 col-sm-4 col-xs-12 profile_details"
				ng-repeat="x in users">
				<div class="well profile_view">
					<div class="col-sm-12">
						<h4 class="brief">
							<i>{{x.name}}</i>
						</h4>
						<div class="left col-xs-7">
							<h2>Nicole Pearson</h2>
							<ul class="list-unstyled">
								<li><i class="fa fa-building"></i> Address:</li>
								<li><i class="fa fa-phone"></i> Phone #:</li>
							</ul>
						</div>
						<div class="right col-xs-5 text-center">
							<img src="images/img.jpg" alt=""
								class="img-circle img-responsive">
						</div>
					</div>
					<div class="col-xs-12 bottom text-center">
						<div class="col-xs-12 col-sm-6 emphasis">
							<p class="ratings">
								<a>4.0</a> <a href="#"><span class="fa fa-star"></span></a> <a
									href="#"><span class="fa fa-star"></span></a> <a href="#"><span
									class="fa fa-star"></span></a> <a href="#"><span
									class="fa fa-star"></span></a> <a href="#"><span
									class="fa fa-star-o"></span></a>
							</p>
						</div>
						<div class="col-xs-12 col-sm-6 emphasis">
							<button type="button" ng-click="getUser(x.id)" class="btn btn-success btn-xs">
								<i class="fa fa-edit"></i>
							</button>
							<button type="button" class="btn btn-primary btn-xs">
								<i class="fa fa-user"> </i> Manage Role
							</button>
						</div>
					</div>
				</div>
			</div>
	</div>
</div>
<@macro.showFooter>
<script type="text/javascript" src="js/pages/create-users.js"></script>
</@macro.showFooter>

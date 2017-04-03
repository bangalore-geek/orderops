<#import "/spring.ftl" as spring /> <#import "macro.ftl" as macro/>

<@macro.showHeader />

<div ng-controller="createUsersCtrl">
	
		<div ng-if="!displayAddForm">
			<button ng-click="addForm();" class="btn btn-default pull-right"><i class="fa fa-plus" aria-hidden="true"></i>&nbsp;&nbspAdd User</button>
		</div>
		
		<div ng-if="displayAddForm">
			<div class="col-md-6 col-sm-6 col-xs-12">
				<div class="x_panel" style="border-top: 5px solid green;">
					<div class="x_title">
						<h4>Register User</h4>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<div class="form-horizontal">
							<div class="form-group">
								<label class="control-label col-sm-4">First Name:</label>
								<div class="col-sm-8">
									<input type="text" ng-model="thisUser.firstName"
										class="form-control" value="{{thisUser.name}}" required>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-4">Last Name:</label>
								<div class="col-sm-8">
									<input type="text" ng-model="thisUser.lastName"
										class="form-control" value="{{thisUser.name}}" required>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-4">User Name:</label>
								<div class="col-sm-8">
									<input type="text" ng-model="thisUser.userName" name="userName"
										class="form-control" value="{{thisUser.userNmae}}" required>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-4">Email Id:</label>
								<div class="col-sm-8">
									<input type="text" ng-model="thisUser.email" name="email"
										value="{{thisUser.email}}" class="form-control" required />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-4">Active</label>
								<div class="col-sm-8">
									<select ng-model="thisUser.active"
										class="select2_multiple form-control">
										<option value="true">true</option>
										<option value="false">false</option>

									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-4">Manager</label>
								<div class="col-md-8">
									<select ng-model="thisUser.salesManagerId"
										class="select2_multiple form-control">
										<option ng-repeat="thisUser in users" value="{{thisUser.id}}">{{thisUser.name}}</option>
									</select>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-4">Role</label>
								<div class="col-md-8">
									<select ng-model="thisUser.roleId"
										class="select2_multiple form-control">
										<option ng-repeat="thisRole in roles" value="{{thisRole.id}}">{{thisRole.name}}</option>
									</select>
								</div>
							</div>

							<div class="form-group">
								<div class="col-md-2">
									<button ng-click="closeForm();"
										class="form-control btn-primary">Close</button>
								</div>
								<div class="col-md-2">
									<button ng-click="saveUsers(thisUser)"
										class="form-control btn btn-success">Save</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>


		<div ng-if="!displayAddForm">
			<div class="x_panel">
				<div class="x_content">
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12 text-center">
						</div>
						<div class="clearfix"></div>
						
						<div class="col-md-4 col-sm-4 col-xs-12 profile_details" ng-repeat="x in users">
							<div class="well profile_view" ng-class="{'green-top-border': x.active, 'red-top-border': !x.active}">
								<div class="col-sm-12">
									<div class="left col-xs-7">
										<h2><strong>{{x.name}}</strong></h2>
										<p>
											<strong>Role: </strong> {{x.role.description}}
										</p>
										<ul class="list-unstyled">
											<li><i class="fa fa-envelope" aria-hidden="true"></i> {{x.email}}</li>
											<li>Active: {{x.active ? 'Yes' : 'No'}}</li>
										</ul>
									</div>
									<div class="right col-xs-5 text-center">
										<img class="img-circle img-responsive" alt=""
											src="img/img1.jpg">
									</div>
								</div>
								<div class="col-xs-12 bottom text-center">
									<div class="col-xs-12 col-sm-6 emphasis">
										<button ng-click="getUser(x.id)" class="btn btn-default btn-xs pull-left" type="button">
											<i class="fa fa-pencil"> </i>
										</button>
										<button ng-click="getUser(x.id)" class="btn btn-default btn-xs pull-left" type="button">
											<i class="fa fa-user"> </i> Manage Role
										</button>
									</div>
									<div class="col-xs-12 col-sm-6 emphasis">
										<button class="btn btn-default btn-xs pull-right" type="button">
											<i class="fa fa-user"> </i> View Profile
										</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
</div>

<@macro.showFooter>
<script type="text/javascript" src="js/pages/create-users.js"></script>
</@macro.showFooter>

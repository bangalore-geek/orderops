<#import "/spring.ftl" as spring />
<#import "macro.ftl" as macro/>

<@macro.showHeader />

<div ng-controller="CompanyProfileCtrl">
    <div class="row">
        <div class="col-md-6 col-sm-6 col-xs-12">
            <div class="x_panel" style="border-top:5px solid red;">
                <div class="x_title">
                    <h4>Basic Details<span class="pull-right edit_hover_class" style="cursor:pointer;"><i class="fa fa-pencil" aria-hidden="true"></i></span></h4>
                    <div class="clearfix"></div>
                </div>
                <div class="x_content">
                    <br />
                    <form name="form1" class="form-horizontal form-label-left">

                        <div class="form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="companyName">Company Name</label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input type="text" name="companyName" ng-model="company.companyName" class="form-control col-md-7 col-xs-12" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="companyAddress">Company Address <span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <textarea id="companyAddress" required="required" class="form-control" name="companyAddress"></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="landmark" class="control-label col-md-3 col-sm-3 col-xs-12">Landmark</label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input id="landmark" class="form-control col-md-7 col-xs-12" type="text" name="landmark">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">Country</label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <select class="select2_single form-control" tabindex="-1" name="country">
                                	<option value="-1">...</option>
                                    <option value="1">India</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">State</label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <select class="select2_single form-control" tabindex="-1" name="state">
                                	<option value="-1">...</option>
                                    <option value="1">Karnataka</option>
                                    <option value="2">Jharkhand</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">District</label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <select class="form-control" tabindex="-1" name="district">
                                	<option value="-1">...</option>
                                    <option value="1">Bangalore</option>
                                    <option value="2">Mysore</option>
                                </select>
                            </div>
                        </div>
                        <div class="ln_solid"></div>
                        <div class="form-group">
                            <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                <button type="button" class="btn btn-primary">Cancel</button>
                                <button type="button" class="btn btn-success" ng-click="save()">Submit</button>
                            </div>
                        </div>

                    </form>
                </div>
            </div>
        </div>
        
        <div class="col-md-6 col-sm-6 col-xs-12">
            <div class="x_panel" style="border-top:5px solid green;">
                <div class="x_title">
                    <h4>Contact Details</h4>
                    <div class="clearfix"></div>
                </div>
                <div class="x_content">
                    <br />
                    <form class="form-horizontal form-label-left">

                        <div class="form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="webUrl">Web Address <span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input type="text" id="webUrl" name="webUrl" required="required" class="form-control col-md-7 col-xs-12">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="systemEmail">System Emails <span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                 <input id="systemEmail" class="form-control col-md-7 col-xs-12" type="text" name="systemEmail">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="contactEmail" class="control-label col-md-3 col-sm-3 col-xs-12">Contact Email</label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input id="contactEmail" class="form-control col-md-7 col-xs-12" type="text" name="contactEmail">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="landLine" class="control-label col-md-3 col-sm-3 col-xs-12">Landline Number</label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input id="landLine" class="form-control col-md-7 col-xs-12" type="text" name="landLine">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="mobile" class="control-label col-md-3 col-sm-3 col-xs-12">Mobile Number</label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input id="mobile" class="form-control col-md-7 col-xs-12" type="text" name="mobile">
                            </div>
                        </div>
                        <div class="ln_solid"></div>
                        <div class="form-group">
                            <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                <button type="submit" class="btn btn-primary">Cancel</button>
                                <button type="submit" class="btn btn-success">Submit</button>
                            </div>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>



<@macro.showFooter>
<script type="text/javascript" src="js/pages/company-profile.js"></script>
</@macro.showFooter>
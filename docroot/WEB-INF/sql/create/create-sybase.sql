use master
exec sp_dboption 'lportal', 'allow nulls by default' , true
go

exec sp_dboption 'lportal', 'select into/bulkcopy/pllsort' , true
go

use lportal

create table Subur_Author (
	authorId decimal(20,0) not null primary key,
	groupId decimal(20,0),
	companyId decimal(20,0),
	title varchar(75) null,
	idType int,
	remoteId varchar(75) null,
	firstName varchar(75) null,
	lastName varchar(75) null,
	middleName varchar(75) null,
	userId int,
	metadata varchar(75) null,
	lastPublishedDate datetime null,
	itemCount int,
	createDate datetime null,
	modifiedDate datetime null,
	Uuid varchar(75) null,
	createdBy decimal(20,0)
)
go

create table Subur_AuthorExpertise (
	authorId decimal(20,0) not null,
	expertiseId decimal(20,0) not null,
	primary key (authorId, expertiseId)
)
go

create table Subur_AuthorSite (
	authorSiteId decimal(20,0) not null primary key,
	authorId decimal(20,0),
	siteName varchar(75) null,
	siteURL varchar(150) null
)
go

create table Subur_DownloadSummary (
	id_ decimal(20,0) not null primary key,
	itemId decimal(20,0),
	perMonth int,
	perYear int,
	status int
)
go

create table Subur_Expertise (
	expertiseId decimal(20,0) not null primary key,
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	createDate datetime null,
	expertiseName varchar(75) null,
	indexedName varchar(75) null,
	modifiedDate datetime null,
	authorCount int
)
go

create table Subur_Item (
	itemId decimal(20,0) not null primary key,
	companyId decimal(20,0),
	groupId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	publishedDate datetime null,
	title varchar(255) null,
	itemAbstract text null,
	language varchar(75) null,
	status int,
	Uuid varchar(75) null,
	metadataValue text null
)
go

create table Subur_ItemAuthor (
	itemId decimal(20,0) not null,
	authorId decimal(20,0) not null,
	primary key (itemId, authorId)
)
go

create table Subur_ItemFileEntry (
	itemId decimal(20,0) not null,
	fileEntryId decimal(20,0) not null,
	entryType decimal(20,0),
	primary key (itemId, fileEntryId)
)
go

create table Subur_ItemItemType (
	itemId decimal(20,0) not null,
	itemTypeId decimal(20,0) not null,
	primary key (itemId, itemTypeId)
)
go

create table Subur_ItemType (
	itemTypeId decimal(20,0) not null primary key,
	itemTypeName varchar(75) null,
	itemCount int
)
go

create table Subur_ItemTypeTemplate (
	itemTypeId decimal(20,0) not null,
	metadataPropertyId decimal(20,0) not null,
	required int,
	primary key (itemTypeId, metadataPropertyId)
)
go

create table Subur_MetadataProperty (
	metadataPropertyId decimal(20,0) not null primary key,
	metadataSchemaId decimal(20,0),
	element varchar(255) null,
	scope varchar(255) null,
	note varchar(1024) null
)
go

create table Subur_MetadataPropertyValue (
	metadataPropertyValueId decimal(20,0) not null primary key,
	itemId decimal(20,0),
	propertyId decimal(20,0),
	textValue text null,
	itemCount int
)
go

create table Subur_MetadataSchema (
	metadataSchemaId decimal(20,0) not null primary key,
	metadataName varchar(1024) null,
	nameSpace varchar(75) null
)
go

create table Subur_StatDownloadCategory (
	id_ decimal(20,0) not null primary key,
	perMonth int,
	perYear int,
	categoryId decimal(20,0)
)
go

create table Subur_StatDownloadItemType (
	id_ decimal(20,0) not null primary key,
	perMonth int,
	perYear int,
	itemTypeId decimal(20,0)
)
go

create table Subur_StatDownloadPeriod (
	id_ decimal(20,0) not null primary key,
	itemId decimal(20,0),
	perMonth int,
	perYear int
)
go

create table Subur_StatDownloadTag (
	id_ decimal(20,0) not null primary key,
	perMonth int,
	perYear int,
	tagId decimal(20,0)
)
go

create table Subur_StatViewCategory (
	id_ decimal(20,0) not null primary key,
	perMonth int,
	perYear int,
	categoryId decimal(20,0)
)
go

create table Subur_StatViewItemType (
	id_ decimal(20,0) not null primary key,
	perMonth int,
	perYear int,
	itemTypeId decimal(20,0)
)
go

create table Subur_StatViewTag (
	id_ decimal(20,0) not null primary key,
	perMonth int,
	perYear int,
	tagId decimal(20,0)
)
go

create table Subur_ViewSummary (
	id_ decimal(20,0) not null primary key,
	itemId decimal(20,0),
	perMonth int,
	perYear int,
	status int
)
go

create table item (
	itemId decimal(20,0) not null primary key,
	companyId decimal(20,0),
	groupId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	title varchar(75) null,
	itemAbstract varchar(75) null,
	status int
)
go

create table subur_Author (
	authorId decimal(20,0) not null primary key,
	groupId decimal(20,0),
	companyId decimal(20,0),
	title varchar(75) null,
	idType int,
	remoteId varchar(75) null,
	firstName varchar(75) null,
	lastName varchar(75) null,
	userId int,
	metadata varchar(75) null,
	lastPublishedDate datetime null,
	itemCount int,
	personalSite varchar(75) null,
	googleScholar varchar(120) null
)
go

create table subur_AuthorExpertise (
	authorId decimal(20,0) not null,
	expertiseId decimal(20,0) not null,
	primary key (authorId, expertiseId)
)
go

create table subur_Division (
	divisionId decimal(20,0) not null primary key,
	parentId decimal(20,0),
	divisionName varchar(75) null,
	depositable int
)
go

create table subur_DownloadSummary (
	id_ decimal(20,0) not null primary key,
	itemId decimal(20,0),
	perMonth int,
	perYear int,
	status int
)
go

create table subur_Expertise (
	expertiseId decimal(20,0) not null primary key,
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	createDate datetime null,
	expertiseName varchar(75) null,
	indexedName varchar(75) null,
	modifiedDate datetime null,
	authorCount int
)
go

create table subur_FileEntryType (
	typeId decimal(20,0) not null primary key,
	typeName varchar(75) null
)
go

create table subur_Item (
	itemId decimal(20,0) not null primary key,
	companyId decimal(20,0),
	groupId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	title varchar(1024) null,
	itemAbstract varchar(1000) null,
	status int
)
go

create table subur_ItemAuthor (
	itemId decimal(20,0) not null,
	authorId decimal(20,0) not null,
	primary key (itemId, authorId)
)
go

create table subur_ItemDivision (
	itemId decimal(20,0) not null,
	divisionId decimal(20,0) not null,
	primary key (itemId, divisionId)
)
go

create table subur_ItemFileEntry (
	itemId decimal(20,0) not null,
	fileEntryId decimal(20,0) not null,
	entryType decimal(20,0),
	primary key (itemId, fileEntryId)
)
go

create table subur_ItemItemType (
	itemId decimal(20,0) not null,
	itemTypeId decimal(20,0) not null,
	primary key (itemId, itemTypeId)
)
go

create table subur_ItemSubject (
	itemId decimal(20,0) not null,
	subjectId decimal(20,0) not null,
	primary key (itemId, subjectId)
)
go

create table subur_ItemType (
	ItemTypeId decimal(20,0) not null primary key,
	ItemTypeName varchar(75) null,
	itemCount int
)
go

create table subur_ItemTypeTemplate (
	itemTypeId decimal(20,0) not null,
	metadataPropertyId decimal(20,0) not null,
	required int,
	primary key (itemTypeId, metadataPropertyId)
)
go

create table subur_MetadataProperty (
	metadataPropertyId decimal(20,0) not null primary key,
	metadataSchemaId decimal(20,0),
	element varchar(255) null,
	scope varchar(255) null,
	note varchar(1024) null
)
go

create table subur_MetadataPropertyValue (
	metadataPropertyValueId decimal(20,0) not null primary key,
	itemId decimal(20,0),
	propertyId decimal(20,0),
	textValue text null,
	itemCount int
)
go

create table subur_MetadataSchema (
	metadataSchemaId decimal(20,0) not null primary key,
	metadataName varchar(1024) null,
	nameSpace varchar(75) null
)
go

create table subur_MetadataValue (
	metadataValueId decimal(20,0) not null primary key,
	itemId decimal(20,0),
	propertyId decimal(20,0),
	textValue varchar(75) null
)
go

create table subur_MetadataValueView (
	propertyId decimal(20,0) not null,
	subjectId decimal(20,0) not null,
	subjectName varchar(75) null,
	textValue varchar(75) null,
	itemCount int,
	primary key (propertyId, subjectId)
)
go

create table subur_StatDownloadCategory (
	id_ decimal(20,0) not null primary key,
	perMonth int,
	perYear int,
	categoryId decimal(20,0)
)
go

create table subur_StatDownloadItemType (
	id_ decimal(20,0) not null primary key,
	perMonth int,
	perYear int,
	itemTypeId decimal(20,0)
)
go

create table subur_StatDownloadPeriod (
	id_ decimal(20,0) not null primary key,
	itemId decimal(20,0),
	perMonth int,
	perYear int
)
go

create table subur_StatDownloadTag (
	id_ decimal(20,0) not null primary key,
	perMonth int,
	perYear int,
	tagId decimal(20,0)
)
go

create table subur_StatViewCategory (
	id_ decimal(20,0) not null primary key,
	perMonth int,
	perYear int,
	categoryId decimal(20,0)
)
go

create table subur_StatViewItemType (
	id_ decimal(20,0) not null primary key,
	perMonth int,
	perYear int,
	itemTypeId decimal(20,0)
)
go

create table subur_StatViewPeriod (
	id_ decimal(20,0) not null primary key,
	itemId decimal(20,0),
	perMonth int,
	perYear int
)
go

create table subur_StatViewTag (
	id_ decimal(20,0) not null primary key,
	perMonth int,
	perYear int,
	tagId decimal(20,0)
)
go

create table subur_Subject (
	subjectId decimal(20,0) not null primary key,
	parentId decimal(20,0),
	subjectName varchar(75) null,
	lft int,
	rgt int,
	depositable int,
	itemCount int
)
go

create table subur_SubjectTree (
	subjectId decimal(20,0) not null primary key,
	parentId decimal(20,0),
	subjectName varchar(75) null,
	lft int,
	rgt int,
	depositable int,
	itemCount int
)
go

create table subur_ViewSummary (
	id_ decimal(20,0) not null primary key,
	itemId decimal(20,0),
	perMonth int,
	perYear int,
	status int
)
go

create table subur_item (
	itemId decimal(20,0) not null primary key,
	companyId decimal(20,0),
	groupId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	publishedDate datetime null,
	title varchar(255) null,
	itemAbstract text null,
	language varchar(75) null,
	status int,
	Uuid varchar(75) null,
	metadataValue text null
)
go





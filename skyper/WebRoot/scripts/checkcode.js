Pn.ns('JCore','JCore.CheckCode');
/**
 * @param input
 *            ��֤�������jquery����
 * @param url
 *            ��֤���url��ַ��
 * @param top
 *            ����ƫ������
 */
JCore.CheckCode.cssClass = 'j-chkcode';
JCore.CheckCode.url = '/CheckCode.svl';
JCore.CheckCode = function(input, url, top) {
	this.input = input;
	this.url = url || JCore.CheckCode.url;
	this.top = top || 45;
	this.imgLayer = null;
	this.img = null;
	this.event = null;
	this.isShow = false;
	var o = this;
	var showImg = function() {
		if (o.imgLayer == null) {
			o.createHtml();
		}
		if (!o.isShow) {
			var d = new Date().getTime();
			o.img.attr('src', o.url + '?d=' + d);
			var offset = o.input.offset();
			o.imgLayer.show();
			o.imgLayer.css('top', offset.top - o.top + 'px');
			o.imgLayer.css('left', offset.left + 'px');
			o.isShow = true;
		}
	};
	var hideImg = function() {
		if (o.isShow) {
			o.event = setTimeout(function() {
				o.imgLayer.hide();
				o.isShow = false;
			}, 200);
		}
	};
	this.input.bind('focus', showImg);
	this.input.bind('blur', hideImg);
};
JCore.CheckCode.prototype.createHtml = function() {
	this.imgLayer = $('<div/>');
	this.img = $('<img border="0" alt="��֤�뿴�����?����ˢ����֤��"/>');
	var o = this;
	this.img.bind('click', function() {
		o.input.focus();
		if (o.event) {
			clearTimeout(o.event);
		}
		this.src = o.url + '?d=' + new Date().getTime();
	});
	this.img.appendTo(this.imgLayer);
	this.imgLayer.appendTo(document.body);
	this.imgLayer.addClass('j-chkcode');
};